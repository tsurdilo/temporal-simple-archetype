# temporal-simple-archetype

Maven archetype to create a simple Temporal Java project

## Getting Started

### Installing

1. Clone this project and build it

```
git clone git@github.com:tsurdilo/temporal-simple-archetype.git
cd temporal-simple-archetype
mvn clean install
```
2. Go to a directory where you want to create your new Temporal Java project and run:


```
mvn archetype:generate -DarchetypeGroupId=io.temporal -DarchetypeArtifactId=temporal-simple-archetype -DarchetypeVersion=1.0.0 -DgroupId=io.myproject -DartifactId=temporal-java-project -DclassPrefix=Temporal
```

Change values of "-DgroupId", "-DartifactId" and "-DclassPrefix"
to what you want.

3. CD into the project that was created for you

4. Build your new project and run the tests:

```
mvn clean install
```

#### Post-Installing

Free free to change your new Temporal Java project as you wish
and learn about Temporal :)

#### Running the Temporal Server, Worker and Starter

To run the created greeting workflow you have to have the Temporal server installed.
Easy way is to do that with [Docker Compose](https://docs.docker.com/compose/gettingstarted/).

1. Start the Temporal Server

In your created project run:
```
docker-compose -f docker-compose-cas-es.yml up
```

2. Run the Worker

3. Run the Starter
