# Use Tomcat 10.1 with Java 17
FROM tomcat:10.1-jdk17

# Remove default Tomcat ROOT application
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copy your WAR file to Tomcat webapps directory
COPY target/simple_inventory_system-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# Expose port 8080 for web access
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
