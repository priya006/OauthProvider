# scala-oauth2-provider example with Skinny-ORM

- [scala-oauth2-provider](https://github.com/nulab/scala-oauth2-provider) 0.17.x
- [Play Framework](https://www.playframework.com/) 2.5.x
- [Skinny-ORM](http://skinny-framework.org/documentation/orm.html) 2.0.x

## Running Play Framework with evolutions

```
$ sbt -Dplay.evolutions.db.default.autoApply=true run
```

## Try to create access tokens using curl

### Client credentials

```
$ curl http://localhost:9000/oauth/access_token -X POST -d "client_id=bob_client_id" -d "client_secret=bob_client_secret" -d "grant_type=client_credentials"
```

### Authorization code

```
$ curl http://localhost:9000/oauth/access_token -X POST -d "client_id=alice_client_id" -d "client_secret=alice_client_secret" -d "redirect_uri=http://localhost:3000/callback" -d "code=bob_code" -d "grant_type=authorization_code"
```

NOTE: A service needs to generate `code` in advance. In this example, the code has been inserted in database by evolutions.

### Password

```
$ curl http://localhost:9000/oauth/access_token -X POST -d "client_id=alice_client_id2" -d "client_secret=alice_client_secret2" -d "username=alice@example.com" -d "password=alice" -d "grant_type=password"
```

### Refresh token

```
$ curl http://localhost:9000/oauth/access_token -X POST -d "client_id=alice_client_id2" -d "client_secret=alice_client_secret2" -d "refresh_token=${refresh_token}" -d "grant_type=refresh_token"
```

NOTE: `${refresh_token}` is you got `refresh_token` from json of password grant. (client_id and client_secret are also same with password grant)

### Access resource using access_token

You can access application resource using access token.

```
$ curl --dump-header - -H "Authorization: Bearer ${access_token}" http://localhost:9000/resources
```

In this example, server just returns authorized user information.

```
HTTP/1.1 200 OK
Content-Type: application/json; charset=utf-8
Content-Length: 90

{"account":{"email":"alice@example.com"},"clientId":"alice_client_id2","redirectUri":null}
```
# Webapp using play framework
![Oauth_provider](https://github.com/priya006/OauthProvider/blob/master/OauthProvider.png)


# Notes
1. `url = "jdbc:h2:mem:play"` tells that we are usng H2 in memory databse
2. `/..../conf/evolutions/default/1.sql` is the script with sql table and values
3. `plugins.sbt` has needed plugins to run the app
4. `build.sbt` has all the dependencies
5. `build.properties` has the sbt version
6. `logback.xml` is a configuration file for logging
7. `Routes` has all rest path
8. `views` folder has code needed for web application provided by play framework
9. 1.sql is a sql script  which runs on default database to create tables and keys
10. H2 in memory Database name is `default`


# Undertstanding
**Database**
I was able to connect to H2 database using H2 [http://www.h2database.com/html/download.html]
But i was not able to connect to the running database of ours.

This project is a wrapper build on https://github.com/nulab/play2-oauth2-provider

# Idea

In all the above curl command pay attention to `grant_type`. Our motto is to access /resources and we need `acccess token` to do that. So we can use any `grant_type` and do it. More about [Authorization grant types](https://oauth.net/2/grant-types/)

The idea is say we are going to create an application called Priya and we have this as our oauth provider
If a application like  whats app likes to talk to priya app. Then Whats app is a client app and it has to register in the Priya app’s Oauth Provider.
While registering what’s app gives its client_id and client_secret
to get acess token
Actually before this step the client ID and secret exist in Priya oauth provider database. (Companies register the client app manually or they use customer service to do it)

# How to open the Scala project In IntelliJ?
1.Install the below plugins in IntelliJ Idea
![Plugins](https://github.com/priya006/OauthProvider/blob/master/ScalaPlugins.png)

2. Open the project as Scala SBT project in intelliJ Idea
![SBT](https://github.com/priya006/OauthProvider/blob/master/IntelliJ%20SBT.png)


# How to Debug Play SBT Project in intelliJ?
1. Run the command `sbt run -jvm-debug 9000 -Dplay.evolutions.db.default.autoApply=true` in terminal 
2. Set the Break points. Example in the line  `OAuthGrantType.REFRESH_TOKEN -> new RefreshToken()`
3. Create a Remote Task in Run/Debug configurations ![Run debug](https://github.com/priya006/OauthProvider/blob/master/Run%20Debug%20Configuration.png) and click Debug option in intelliJ
4. Fire the curl command `curl http://localhost:9000/oauth/access_token -X POST -d "client_id=bob_client_id" -d "client_secret=bob_client_secret" -d "grant_type=client_credentials"`
5. Yay! Now You are in debug mode! ![Debug](https://github.com/priya006/OauthProvider/blob/master/Debug_Mode.png)

# How to run the test?
1. Run the command `sbt test` It runs the test suite using the ScalaTest as a dependency in the build.sbt file.

