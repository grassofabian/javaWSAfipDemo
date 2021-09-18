# javaWSAfipDemo
Código de ejemplo para el uso de la librería javaWSAfip.

Unase a nuestro grupo para realizar consultas, pedir ayuda u opinar sobre la librería. Link del grupo para unirse: https://groups.google.com/g/javaWSAfip

El certificado digital .pfx es para test, es el mío para que prueben la librería. Pueden usar el de Ustedes si lo desean.

Directorios importantes y archivo de configuración que deben existir sí o sí en la raiz del proyecto que uds. realicen:

Directorios:
/certs/ "en este derectorio se deben incluir el o los certificados .pfx firmados en formato p12. Sean certificados para Test o Producción
/credentials/ "aquí existen archivos que incluyen tanto el sign como el token de autorización, etx. No deben ser modificados.

Archivo de Configuración: /configuracion.cfg "En este archivo se deben configurar diferentes parámetros detallados a continuación:"

Contenido del archivo de configuración:

# -----Datos para usar en modo de produccion --------------------------------------------------------------
# ---La clave del producto sera remitida por nosotros cuando compre nuestra libreria-----------------------
produccion=no
mail=
password=

# ------Servicio para el cual se requiere el ticket de acceso y padron------------------------------------
service=wsfe
serviceP=ws_sr_padron_a5

# -----Destino del Servicio------------------------------------------------------------------------------
# --Para produccion
#dstdn=cn=wsaa,o=afip,c=ar,serialNumber=CUIT 33693450239
#dstdnP=cn=wsaa,o=afip,c=ar,serialNumber=CUIT 33693450239

# --Para Test
dstdn=cn=wsaahomo,o=afip,c=ar,serialNumber=CUIT 33693450239
dstdnP=cn=wsaahomo,o=afip,c=ar,serialNumber=CUIT 33693450239 

# -----Keystore en formato PKCS#12 que posee el certificado del computador que solicita el acceso--------
keystore=certs/22433523.pfx

# -----Signer del certificado en el keystore-------------------------------------------------------------
keystore-signer=1

# -----Clave de acceso al keystore-----------------------------------------------------------------------
keystore-password=12345

# -----Tiempo de vida del ticket requerido---------------------------------------------------------------
TicketTime=36000
