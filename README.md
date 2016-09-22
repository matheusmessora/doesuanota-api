# doesuanota-api

[![Build Status](https://travis-ci.org/matheusmessora/doesuanota-api.svg?branch=master)](https://travis-ci.org/matheusmessora/doesuanota-api)

REST API for www.doesuanota.com.br

# API

| URL | Method | Action |
| --- | --- | --- |
| http://api.doesuanota.com.br/participants | GET | Return all registered participants |
| http://api.doesuanota.com.br/participants | POST | Register a new participant if is not already registered |
| http://api.doesuanota.com.br/surveys/{token}| GET | Return survey for the given token |
| http://api.doesuanota.com.br/surveys/{token}/answers| POST | Answer the survey |

# Production Environment

![aws](https://s3.amazonaws.com/doesuanota.com.br/img/cloudcraft+-+doesuanota-backend+(2).png)