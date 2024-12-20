# Data Parser

## Overview
This project involves parsing JSON data for market analysis, focusing on extracting specific data for each hour of the day.

### Data Source
The JSON data required for parsing is : `apx-data.json`.

## Data Extraction Requirements
For each hour of the day, the following data needs to be parsed:
- **Date (`date_applied` in JSON)**: The raw data is in milliseconds since epoch start (start of day). This needs to be converted to the date in the Netherlands time zone.
- **Hour**: Based on either the "Order" or "Hour" field in the JSON, determine the hour-of-day for which the data row is applicable.
- **Net Volume**: Extract the value from the "Net Volume" field.
- **Price**: Extract the value from the "Price" field.

## JSON Parsing
We use Jackson for JSON parsing but you can use any other package.

## Implementation Steps
1. **Define Object Model in Java**: Create Java classes that represent the data model for the parsed JSON.
2. **Implement Parsing Code**: Write Java code to parse the JSON into the defined object model.
3. **Testing**: Implement tests (Unit Test) to ensure the JSON is parsed correctly. This includes loading sample data from the classpath and verifying its integrity.

## Building the Project
You can build the project using Maven.
