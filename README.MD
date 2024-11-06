## Pokemon SOAP app

## Requisitos 
* java 17 
* maven

## Compilacion
```.
mvn clean install
```

## Ejecucion
```.
java -jar .\pokemonApp-0.0.1.jar

```

## SoapUI
* http:// localhost:8080/ws
request
```.
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:gen="http://www.mysoapws.com/soap/gen">
   <soapenv:Header/>
   <soapenv:Body>
      <gen:pokemonServiceRequest>
         <gen:offset>0</gen:offset>
         <gen:limit>16</gen:limit>
      </gen:pokemonServiceRequest>
   </soapenv:Body>
</soapenv:Envelope>
```
* Notas: se adjuntan evidencias de funcionamiento en pc.
![Screenshot 2024-11-06 143311.png](evidencia%2FScreenshot%202024-11-06%20143311.png)
* wsdl
http://localhost:8080/ws/pokemonWsdl.wsdl
* Muchas gracias.


