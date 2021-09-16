package prueba;

import javaWSAfip.wsaa;
import javaWSAfip.wsaa_padron;
import javaWSAfip.wsfe;

public class prueba {
		
		public static void main(String[] args) throws Exception {
			
			// TODO Auto-generated method stub
			String resp_cae_xml =null;
			String resp_compro_xml =null;
			String resp_tipos_documentos_xml =null;
			String resp_tipos_compro_xml =null;
			String resp_alicuotas_IVA_xml =null;
			String resp_monedas_xml =null;
			String resp_cotizacion_monedas_xml =null;
			String resp_tipos_de_concepto_xml =null;
			String resp_puntos_de_venta_autorizados_xml =null;
			String resp_tipos_tributos_xml =null;
			String resp_dummy =null;
			String resp_padron_xml =null;
			int resp_ultcompr =0;
		    		
			
			//Compruebo el buen funcionamiento del Servidor WSFE de la AFIP
			resp_dummy =wsfe.wsfe_Dummy();
			System.out.println("-------------------------Comprobacion del Funcionamiento del Servidor AFIP-------------------------");
	        System.out.println("Estado del Servidor: "+resp_dummy);	        	        
			
			//Invoco al WSAA para obtener Token y Sign
	        wsaa.wsaa_autorizacion();
	        System.out.println("-------------------------XML de respuesta de autorizacion-------------------------");
	        System.out.println("Estado del Servidor: "+wsaa.autorizacion_xml);
	        	        
	        //Primero se deben cargar las líneas del comprobante
	        //cargo lineas comprobante
	        demofac.lineas_a();
	        //////////////////////////////////////////////////////	        
	        
	        //Consulta Ultimo Comprobante emitido
	        System.out.println("-------------------------Numero Ultimo Comprobante Emitido-------------------------");
	        //wsfe_UltCompr(CUIT,Punto de Venta,Codigo de Comprobante)
	        resp_ultcompr = wsfe.wsfe_UltCompr("20224335238",2,1);	        
	        System.out.println("Ultimo comprobante: "+resp_ultcompr);
	        
	        wsfe.CantReg=1; //no se debe cambiar
	        wsfe.CbteTipo = 1; //Codigo de Factura A
			wsfe.PtoVta = 2; //punto de venta
			wsfe.Concepto=1; //1:Productos 2:Servicios 3:Productos y Servicios
			wsfe.DocTipo=80; //Tipo de documento CUIT
			wsfe.DocNro="20077704257"; //CUIT del emisor del comprobante
			wsfe.CbteDesde=resp_ultcompr+1; //numero correlativo del comprobante a generar
			wsfe.CbteHasta=resp_ultcompr+1;
			wsfe.CbteFch="20210913"; //fecha del comprobante formato AAAAMMDD
			wsfe.FchServDesde=""; //se debe especificar en el caso que Conceptos sean 2 o 3, Servicios o Productos y Servicios
			wsfe.FchServHasta=""; //se debe especificar en el caso que Conceptos sean 2 o 3, Servicios o Productos y Servicios
			wsfe.FchServVto=""; //Fecha de Vencimiento. Se debe especificar en el caso que Conceptos sean 2 o 3, Servicios o Productos y Servicios
			wsfe.ImpOpEx=0; 
			wsfe.ImpTotConc=0;
			wsfe.ImpTotal=wsfe.totlizar_total()+wsfe.ImpOpEx+wsfe.ImpTotConc; //suma de impNeto + importes tributados + IVA						
			wsfe.ImpNeto=wsfe.totlizar_neto(); //importe sin iva/s			
			wsfe.ImpTrib=wsfe.totlizar_tributos(); //Suma total de importe de cada tributo -- ImpTrib=0 si no se agregan impuestos			
			wsfe.ImpIVA=wsfe.totlizar_ivas(); //total de los ivas
			wsfe.MonId="PES";
	        wsfe.MonCotiz=1;
	          
	            //Una vez llenado todos los campos anteriores se solicita el CAE
				//Solicito el CAE
				resp_cae_xml = wsfe.wsfe_FECAESolicitar("20224335238");
				System.out.println("-------------------------CAPTURO EL CAE-------------------------");
				System.out.println("CAE: "+ wsfe.CAE); //en wsfe.CAE se guarda el CAE
				System.out.println("Resultado: "+ wsfe.Resultado); //en wsfe.Resultado nos indica si fue aprobado o rechazado
				System.out.println("Vencimiento del CAE: "+ wsfe.CAE_Vencimiento); //en wsfe.CAE_Vencimiento se guarda el vencimiento del CAE
				System.out.println("-------------------------XML CAE-------------------------");
				System.out.println(resp_cae_xml); //en resp_cae_xml se guarda el XML de respuesta de la solicitud, por si se quiere consultar en caso de errores.
				//Compruebo si hay errores
				if (wsfe.WSFE_Cantidad_Errores!=0){
					for (int i = 0; i < wsfe.WSFE_Cantidad_Errores; i++){
						System.out.println("Errores: "+wsfe.WSFE_Errores.get(i));
					}	
				}
				
				//Consulto un Comprobante Autorizado
				//wsfe_ConsultarComprobanteEmitido(CUIT, TipoComprobante, NumComprobante, PtoVenta)
		        resp_compro_xml = wsfe.wsfe_ConsultarComprobanteEmitido("20224335238", 1, 217, 2);
				System.out.println("-------------------------XML CONSULTA DE UN COMPROBANTE AUTORIZADO-------------------------");
				System.out.println(resp_compro_xml);  
				
				//Consulto tipos de comprobantes permitidos para el CUIT
		/*		resp_tipos_compro_xml = wsfe.wsfe_ConsultarTiposComprobantes("20224335238");
				System.out.println("-------------------------XML TIPOS DE COMPROBANTES PERMITIDOS-------------------------");
				System.out.println(resp_tipos_compro_xml); */
				
		/*		//Constulto tipos de Documentos
				System.out.println("-------------------------XML TIPOS DE DOCUMENTOS-------------------------");
				resp_tipos_documentos_xml = wsfe.wsfe_consultarTiposDocumento("20224335238");
				System.out.println(resp_tipos_documentos_xml); */
				
		/*		//Constulto Alicuotas de IVA
				System.out.println("-------------------------XML ALICUOTAS IVA-------------------------");
				resp_alicuotas_IVA_xml = wsfe.wsfe_consultarAlicuotasIVA("20224335238");
				System.out.println(resp_alicuotas_IVA_xml); */
							
		/*		//Consulto Monedas
				System.out.println("-------------------------XML MONEDAS-------------------------");
				resp_monedas_xml=wsfe.wsfe_consultarMonedas("20224335238");
				System.out.println(resp_monedas_xml); */
				
		/*		//Consulto Cotización de Moneda
				System.out.println("-------------------------XML COTIZACON MONEDAS-------------------------");
				resp_cotizacion_monedas_xml = wsfe.wsfe_consultarCotizacionMoneda("20224335238", "DOL");
				System.out.println(resp_cotizacion_monedas_xml); */
							
				
		/*		//Consulto Puntos de Venta Autorizados para Facturas Electronicas
				System.out.println("-------------------------XML PUNTOS DE VENTA AUTORIZADOS-------------------------");
				resp_puntos_de_venta_autorizados_xml = wsfe.wsfe_PuntosdeVentaHabilitados("20224335238");
				System.out.println(resp_puntos_de_venta_autorizados_xml); */ 
				
		/*		//Consulto Tipos de Tributos
				System.out.println("-------------------------XML TIPOS DE TRIBUTOS-------------------------");
				resp_tipos_tributos_xml = wsfe.wsfe_TiposdeTributos("20224335238");
				System.out.println(resp_tipos_tributos_xml); */
				
				//Consulto Tipos de Conceptos
		/*		System.out.println("-------------------------XML TIPOS DE CONCEPTOS-------------------------");
				resp_tipos_de_concepto_xml = wsfe.wsfe_TiposdeConceptos("20224335238");
				System.out.println(resp_tipos_de_concepto_xml); */	
				
				System.out.println("-------------------------PADRON-------------------------");
				System.out.println("Estado del Servidor del Padron: "+wsfe.wsfe_DummyP());
				wsaa_padron.wsaa_padronContri();
				wsfe.wsfe_Padron("20224335238","33693450239");
				System.out.println("Razon Social: "+wsfe.Padron_RazonSocial);
				System.out.println("Domicilio: "+wsfe.Padron_Domicilio);
				System.out.println("I.V.A: "+wsfe.Padron_IVA);
				System.out.println("Provincia: "+wsfe.Padron_Provincia);
				System.out.println("Estado: "+wsfe.Padron_Estado);
		}    	
}
