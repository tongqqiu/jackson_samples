jackson_samples
===============

[![Build Status](https://travis-ci.org/tongqqiu/jackson_samples.svg?branch=master)](https://travis-ci.org/tongqqiu/jackson_samples)



More advanced Jackson example for JSON object data binding

Typical JSON like

    {
        'abc': 'string',
        'xyz': 1,
        _cached : true
    }


In Java, we model it as LinkedHashMap. JsonExampleTest shows the test case.

To run the test:

    mvn test