# prueba-tecnica
<h2>Users Controller</h2>
<h4>permite la creación de usuarios, requiere los siguientes parametros</h4>
<ol>
  <li>Name</li>
  <li>Username</li>
  <li>Email</li>
  <li>Phone</li>
</ol>
<p>(Este método requiere autenticación basic auth)</p>
<h4>permite la búsqueda de todos los Usuarios almacenados en la base de datos</h4>
<h4>permite la eliminación de un usuario mediante su id</h4>
<p>(Este método requiere autenticación basic auth)</p>
<h4>permite la búsqueda de usuarios mediante su email</h4>
Las credenciales se deben definir en el archivo properties

<h2>Search</h2>

Mediante el ingreso de la cadena "1-9" en el formato { "param" : "1-9" }
el parámetro será cifrado en <b>DES</b> y luego en <b>BASE64</b> dando por resultado <b>FyaSTkGi8So=</b> 
<p>
una vez cifrado asumirá el valor param para consumir la api

<a href="https://my.api.mockaroo.com/test-tecnico/search/FyaSTkGi8So=">https://my.api.mockaroo.com/test-tecnico/search/{param}</a>

mediremos el tiempo de ejecución y generaremos la respuesta en el siguiente formato
</p>
{
    "responseCode": "200",
    "description": "OK",
    "elapsedTime": 1289,
    "result": {
        "registerCount": 3
    }
}
<p>y en caso de error </p>
{
    "responseCode": "204",
    "description": "NOK",
    "elapsedTime": 636,
    "result": {
        "registerCount": 0
    }
}

