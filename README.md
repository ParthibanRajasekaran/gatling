# Gatling

Gatling is a powerful tool for load and performance testing web applications. Here are the steps to get started with Gatling:

## Step 1: Install Gatling

Gatling can be downloaded from the official [Gatling website](https://gatling.io/open-source). You can choose to download the binary distribution or the source distribution. Launch the recorder from the bin folder using

```bash
sh ./gatling.sh
```

Install [Scala](https://docs.scala-lang.org/getting-started/index.html)

Install [JDK](https://www.oracle.com/uk/java/technologies/downloads), preferably LTS (11 or 17)

## Step 2: Clone the repository and open it in IntelliJ

```bash
git clone https://github.com/ParthibanRajasekaran/gatling.git
```

## Working with the template
- Input files can be added to `src/test/resources/data`
- Gatling simulations get triggered from `src/test/scala/Engine.scala`. It provides an entry point for running Gatling simulations programmatically.
- `src/test/scala/IDEPathHelper` provides utility methods for locating the various directories needed for running Gatling simulations within an IDE environment.
- `src/test/scala/Recorder` provides a convenient way to launch the Gatling recorder, which is a tool for creating Gatling simulations by recording HTTP traffic.
- API simulation classes can be added to `src/test/scala/com/gatling/demo/api`
- GUI simulation classes can be added to `src/test/scala/com/gatling/demo/ui`


_Visit here for_ [Notion notes](https://www.notion.so/Gatling-049c505f89a94cda94caab9b4f189e62?pvs=4)

