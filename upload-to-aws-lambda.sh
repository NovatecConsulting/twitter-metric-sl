#!/bin/bash
aws lambda update-function-code \
--zip-file=fileb://build/distributions/twitter-metric-sl-1.0-SNAPSHOT.zip \
--region=eu-central-1 \
--function-name=TweetsCounter \


envVar=$(cat <<EOF
{
  "Variables": {
    "TWITTER_CONSUMER_KEY":"${CONSUMER_KEY}",
    "TWITTER_CONSUMER_SECRET":"${CONSUMER_SECRET}",
    "TWITTER_ACCESS_TOKEN":"${ACCESS_TOKEN}",
    "TWITTER_ACCESS_TOKEN_SECRET":"${ACCESS_TOKEN_SECRET}"
  }
}
EOF
)

echo $envVar

aws lambda update-function-configuration \
--function-name=TweetsCounter \
--region=eu-central-1 \
--environment "$envVar"