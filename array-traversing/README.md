# Application starts with the main in Application class

# Use "mvn clean install" to build the application and run the tests

# Solution improvements:
    - Logger is used to print the debug values but log level is entered 
    manually in code. That may be changed to be used in a conf. file.
    - Spiral traversion method is a bit complex. It's compexity can be 
    reduced and also less local variables may be used. Maybe to get rid of the 
    bounds of the column and rows, we can keep a different matris which 
    keeps the traversed values as a boolean. That may be reconsidered.