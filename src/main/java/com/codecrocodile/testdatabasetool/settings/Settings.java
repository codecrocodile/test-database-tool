package com.codecrocodile.testdatabasetool.settings;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris on 20/01/2018.
 */
public class Settings implements Serializable {

    private String name;

    private String databaseName;

    private Integer databasePort;

    private File liquibaseChangeSetFile;

    private List<File> dbUnitDatasetFiles = new ArrayList<>();

    private LocalDate lastUpdatedSchema;

    private LocalDate lastUpdatedData;

    private boolean saved;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public Integer getDatabasePort() {
        return databasePort;
    }

    public void setDatabasePort(Integer databasePort) {
        this.databasePort = databasePort;
    }

    public File getLiquibaseChangeSetFile() {
        return liquibaseChangeSetFile;
    }

    public void setLiquibaseChangeSetFile(File liquibaseChangeSetFile) {
        this.liquibaseChangeSetFile = liquibaseChangeSetFile;
    }

    public List<File> getDbUnitDatasetFiles() {
        return dbUnitDatasetFiles;
    }

    public void setDbUnitDatasetFiles(List<File> dbUnitDatasetFiles) {
        this.dbUnitDatasetFiles = dbUnitDatasetFiles;
    }

    public LocalDate getLastUpdatedSchema() {
        return lastUpdatedSchema;
    }

    public void setLastUpdatedSchema(LocalDate lastUpdatedSchema) {
        this.lastUpdatedSchema = lastUpdatedSchema;
    }

    public LocalDate getLastUpdatedData() {
        return lastUpdatedData;
    }

    public void setLastUpdatedData(LocalDate lastUpdatedData) {
        this.lastUpdatedData = lastUpdatedData;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    public List<String> validate() {
        List<String> validationMessages = new ArrayList<>();

        if (name == null || name.length() == 0) {
            validationMessages.add("Settings name required");
        }
        if (databaseName == null || databaseName.length() == 0) {
            validationMessages.add("Database name required");
        }
        if (databasePort == null) {
            validationMessages.add("Database port required");
        }
        if (liquibaseChangeSetFile == null) {
            validationMessages.add("Database schema require");
        }

        return validationMessages;
    }

    @Override
    public String toString() {
        return name;
    }

}
