# muggle
框架基于springmvc搭建，使用maven管理jar包，使用git进行版本管理
1.集成 ibatis
2.集成 redis
3.集成 activemq
4.集成 spring security
5.集成log4j






访问地址:
muggle:localhost:8080/muggle/login
activemq: http://localhost:8161/admin/
solr内置:http://localhost:8080/solr/index.html
solr外置:http://localhost:8983/solr

内置solr服务器步骤
第一步：tomcat9，solr6.6.0.zip
solr6.6.0解压后找到solr-6.4.1/server/server-webapp/目录下的webapp文件夹，复制粘贴到tomcat下的webapps下
 
第二步：把solr-6.6.0/server/lib/ext目录下的所有jar包、和solr-6.6.0/dist下的solr-dataimporthandler-6.6.0.jar、solr-dataimporthandler-extras-6.0.0.jar粘贴复制到tomcat下的solr项目的WEB-INF/lib目录下；
 
第三步：把server目录下的solr文件夹粘贴复制到其他目录，然后重命名为：solrhome，这是solr核心文件夹。
 
第四步：修改tomcat下的solr项目的WEB-INF/web.xml，这一步用来指定默认的solr/home。在web.xml开头附近找到：
 
<env-entry>
  <env-entry-name>solr/home</env-entry-name>
  <env-entry-value>solr home path</env-entry-value>
  <env-entry-type>java.lang.String</env-entry-type>
  </env-entry>
 
然后取消注释，把<env-entry-value>填第三步solrhome文件夹的地址。
 
第五步：在tomcat下的solr项目的WEB-INF下新建classes目录，然后把solr-6.6.0/server/resources下的log4j.properties粘贴过去；
 
第六步：solr/server/lib下metrics开头的5个jar拷到tomcat\webapps\solr\WEB-INF\lib下
 
第七步：去掉权限，tomcat  solr下的web.xml  注意最后一段话
<security-constraint>
    <web-resource-collection>
      <web-resource-name>Disable TRACE</web-resource-name>
      <url-pattern>/</url-pattern>
      <http-method>TRACE</http-method>
    </web-resource-collection>
    <auth-constraint/>
  </security-constraint>
  <security-constraint>
    <web-resource-collection>
      <web-resource-name>Enable everything but TRACE</web-resource-name>
      <url-pattern>/</url-pattern>
      <http-method-omission>TRACE</http-method-omission>
    </web-resource-collection>
  </security-constraint>
  
