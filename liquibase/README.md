# Liquibase Cheatsheet
```
# Check liquibase version
liquibase --version

# Validate configuration
liquibase validate

# Check status of change log file
liquibase status 
# Or
liquibase status --verbose

# Inspect changelog and generate the SQL commands
liquibase update-sql

# Make change to the database
liquibase update

# Inspect rollback one change set and generate the SQL commands
liquibase rollback-count-sql 1

# Rollback one change set
liquibase rollback-count 1

# Get history for all change sets
liquibase history
```

## Usage
### Init liquibase
```
liquibases init
```

### Example Files
#### liquibase.properties
```
# Enter the path for your changelog file.
changeLogFile=changelog.xml

#### Enter the Target database 'url' information  ####
liquibase.command.url=jdbc:postgresql://localhost:5432/liquibase

# Enter the username for your Target database.
liquibase.command.username: postgres

# Enter the password for your Target database.
liquibase.command.password: password
```

#### changelog.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<databaseChangeLog
	xmlns="http://www.liquibase.org/xml/ns/dbchangelog"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:ext="http://www.liquibase.org/xml/ns/dbchangelog-ext"
	xmlns:pro="http://www.liquibase.org/xml/ns/pro"
	xsi:schemaLocation="http://www.liquibase.org/xml/ns/dbchangelog
		http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-latest.xsd
		http://www.liquibase.org/xml/ns/dbchangelog-ext http://www.liquibase.org/xml/ns/dbchangelog/dbchangelog-ext.xsd
		http://www.liquibase.org/xml/ns/pro http://www.liquibase.org/xml/ns/pro/liquibase-pro-latest.xsd">
    <changeSet id="1" author="Liquibase">
        <createTable tableName="test_table">
            <column name="test_id" type="int">
                    <constraints primaryKey="true"/>
            </column>
            <column name="test_column" type="varchar"/>
        </createTable>
    </changeSet>
    <changeSet id="2" author="Rattapong K.">
        <addColumn tableName="test_table">
            <column name="country" type="varchar(2)"/>
        </addColumn>
    </changeSet>
</databaseChangeLog>
```

## References
* [Liquibase Change Types](https://docs.liquibase.com/change-types/home.html)
* [Getting started liquibase with xml](https://docs.liquibase.com/concepts/changelogs/xml-format.html)
* [Using Liquibase with PostgreSQL](https://docs.liquibase.com/install/tutorials/postgresql.html)