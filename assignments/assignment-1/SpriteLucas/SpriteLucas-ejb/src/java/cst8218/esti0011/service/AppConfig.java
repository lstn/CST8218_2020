/*
 * CST8218 Assignment 2
 * Author: Lucas Estienne <esti0011@algonquinlive.com>
 * 2020W Term
 */
package cst8218.esti0011.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.PasswordHash;
import javax.ws.rs.core.Application;

@DatabaseIdentityStoreDefinition(
   dataSourceLookup = "${'java:comp/DefaultDataSource'}",
   callerQuery = "#{'select password from app.appuser where userid = ?'}",
   groupsQuery = "select groupname from app.appuser where userid = ?",
   hashAlgorithm = PasswordHash.class,
   priority = 10
)


/**
 * Application scoped bean to implement security
 * @author lucas.estienne
 */
@BasicAuthenticationMechanismDefinition
@ApplicationScoped
@Named
public class AppConfig extends Application{  }
