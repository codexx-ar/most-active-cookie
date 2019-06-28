# most-active-cookie - description
Command line program which processes the cookie log and returns the most active cookie for specified day.
The most active cookie as one which was seen in the log the most times during a given day.

# To compile and package the project (outputs to jar folder) run at root
mvn clean install

# To run the program, use below command:
sh most_active_cookie.sh <filepath> -d <yyyy-mm-dd>
  
# Assumptions:
1. , is the separator between cookie and date. Can be changed in the most_active_cookie.sh file if needed
2. cookies in the log file are sorted by timestamp (most recent occurrence is
first line of the file)

# Further optimization:
The DataHandler can run parallel processes to process each record as they are read instead of the read all active records for the date and then process approach used. This will remove the need to save it in memory.
File reading optimizations.
