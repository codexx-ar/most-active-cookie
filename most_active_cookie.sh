#!/bin/sh
if [ "$#" -ne 3 ]; then
    echo "Invalid input. Please check format to execute:"
    echo "sh most_active_cookie.sh <file name> -d <yyyy-mm-dd>"
fi
echo "Searching for most active cookies in $1 for the date $3"
java -jar jar/most-active-cookie-1.0.jar $1 $3