# Use Tomcat 10.1 with Java 17
FROM tomcat:10.1-jdk17

# Remove default Tomcat ROOT application
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copy your WAR file to Tomcat webapps directory
COPY target/simple_inventory_system-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# Set environment variables
ENV PORT=8080
ENV DATABASE_URL=simple_inventory_system_db

# Expose the dynamic port
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
