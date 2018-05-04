# Welcome

This playground as the final goal to guide you through the usage of multiple databases with Spring.

The need come in my day job to play with mutliple database depending on the context. In most cases, we need to connect to a central database to know on which local database we need to fetch data. Thus, we mostly work with 2 databases in the same thread.

If you've read articles or Spring documentation, you probably know how to play with a database, and how easy it is. But, what's not easy to find or understand is to plug our Spring projects upon multiple databases.

Via this playground, we'll go through multiple steps, with:

- the usage of a unique database
- the usage of multiple datasources for différents entities / packages
- learing how to use different dabatases depending on the context for the same entities / packages (database sharding)

You can jump from chapter to another, depending on what you know and what you're looking for.

# Plan

In this section you'll find some explanation for the different steps.

## Configuration

To fullfil our tests cases we will need some basis configurations. We will work with 3 MySQL instances, one `central` and two `local` databases.

For a quick and easy configuration I work with Docker.

## Solo database

## Two databases

## Database Sharding

# Final word

The source code is on [GitHub](https://github.com/TechDotIO/Spring5-template), please feel free to come up with proposals to improve it.
