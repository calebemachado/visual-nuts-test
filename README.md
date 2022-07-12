
# Visual Nuts Interview

A simple Java project containing source code answering questions above descripted.
## References

General notes: For all exercises we expect actual runnable Java code and test to be provided.
Imagine that all code you provide here is of the highest importance for the company, and target
core features of our product. So the provided code should be up to production level quality.

### Exercise 1:
Write or describe an algorithm that prints the whole integer numbers to the console, start
from the number 1, and print all numbers going up to the number 100.
However, when the number is divisible by 3, do not print the number, but print the word
'Visual'. If the number is divisible by 5, do not print the number, but print 'Nuts'. And for all
numbers divisible by both (eg: the number 15) the same, but print 'Visual Nuts'.

How will you keep this code safe from bugs? Show how you would guarantee that this code
keeps working when developers start making small feature adjustments. (Maybe we would
want to print the first 500 numbers, ...).

### Exercise 2:
Image you have a set of data in JSON, describing official languages spoken by countries, as
such:
```
[
   {
      "country":"US",
      "languages":[
         "en"
      ]
   },
   {
      "country":"BE",
      "languages":[
         "nl",
         "fr",
         "de"
      ]
   },
   {
      "country":"NL",
      "languages":[
         "nl",
         "fy"
      ]
   },
   {
      "country":"DE",
      "languages":[
         "de"
      ]
   },
   {
      "country":"ES",
      "languages":[
         "es"
      ]
   }
]
```

Write a function in Java that:
- returns the number of countries in the world
- finds the country with the most official languages, where they officially speak German (de).
- that counts all the official languages spoken in the listed countries.
- to find the country with the highest number of official languages.
- to find the most common official language(s), of all countries.

## Requirements

- It was made with Java 18 but should be compatible with 11 and above.
- Maven
## Running Locally

Clone the project

```bash
  git clone https://github.com/calebemachado/visual-nuts-test
```

Enter directory

```bash
  cd visual-nuts-test
```

Install dependencies

```bash
  mvn clean install
```

Run the main application with your favorite IDE

Path:
```
  src/main/java/pt/com/visualnuts/interview/Main.java
```


## Running tests

You can find two java files containing tests for the app on:

```
  src/test/java/pt/com/visualnuts/interview/integerchecker/VisualNutsIntegerCheckerTest.java

  src/test/java/pt/com/visualnuts/interview/jsonlanguages/CountryDataInfoTest.java
```

