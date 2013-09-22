Distributed CDI beans via Coherence

Contexts and Dependency Injection(CDI) is the Java standard for dependency injection and contextual lifecycle management. It comes with JSR-299. JBoss Weld, the JSR-299 Reference Implementation (RI), is being developed as part of the Seam project.

This article shows how to distribute CDI beans by using Coherence. In the following sample application, a new cluster called DATA4J has been created with two nodes and a CDI bean is distributed by using a cache object called user-map.

Used Technologies : JDK 1.7.0_40, Weld 1.1.14.Final, Coherence 3.7.1 and Maven 3.0.4