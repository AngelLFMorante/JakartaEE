# Usa la imagen oficial de WildFly con una versión específica
FROM quay.io/wildfly/wildfly:35.0.1.Final-jdk17

# Copia el archivo WAR a la carpeta de despliegue de WildFly
COPY ./target/myapp-1.0-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/

# Crear el usuario administrador para el admin console
RUN /opt/jboss/wildfly/bin/add-user.sh -u admin -p admin --realm ManagementRealm --groups admin --silent

# Exponer los puertos 8080 (para la aplicación) y 9990 (para la consola de administración)
EXPOSE 8080 9990

# Comando para ejecutar WildFly en modo standalone
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]

