# Usar la imagen oficial de WildFly/JBoss
FROM jboss/wildfly:latest

# Copiar el JAR al directorio de despliegue de WildFly
COPY ./target/myapp-1.0-SNAPSHOT.jar /opt/jboss/wildfly/standalone/deployments/

# Exponer los puertos estándar de JBoss/WildFly
EXPOSE 8080 9990

# Comando para iniciar el servidor
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]
