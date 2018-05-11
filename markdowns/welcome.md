# Welcome

This playground as the final goal to guide you through the usage of databases with Spring, from a simple case with one 
database to a more complex example with multiple database. In my day job, I had to deal with this complex situation and 
didn't find much example to guide me through. 

In this job context, we have to deal with multiple databases, 5/6 local databases, that are the same, but with 
localized information, and one central database is used to store global parameters or where on which local database 
go to find specific data.  

In most cases, we need to connect to the central database to know on which local database we need to fetch data. 
Thus, we mostly work with 2 databases in the same thread.

If you've read articles or Spring documentation, you probably know how to play with a database, even two, and how easy it is. 
But, what's not easy to find or understand is to plug our Spring projects upon multiple databases, for the same type of data.


Via this playground, we'll go through multiple steps, with:

- Databases configuration

To fulfill our tests cases we will need some basis configurations. We will work with 3 MySQL instances, 
one `central` and two `local` databases.

For a quick and easy configuration I work with Docker.

- Solo database : the usage of a unique database
- Two databases : the usage of multiple datasources for différents entities / packages
- Database Sharding 
  -  learning how to use different dabatases depending on the context for the same entities / packages
- Answering our use case by combining the previous steps

You can jump from chapter to another, depending on what you already know and what you're looking for.

# Final word

The source code is on [GitHub](https://github.com/TechDotIO/Spring5-template), please feel free to come up with proposals to improve it.
