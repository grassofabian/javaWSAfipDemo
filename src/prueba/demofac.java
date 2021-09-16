package prueba;

import javaWSAfip.wsfe;

public class demofac {
	public static void lineas_a() {    	
        
	      //Agrego Lineas
		    wsfe.Lineas_Codigo="1";
	        wsfe.Lineas_Desc="Producto 1";
	        wsfe.Lineas_Cant=1;
	        wsfe.Lineas_PU=10;
	        wsfe.Lineas_Alic_IVA="21";
	        wsfe.Lineas_Subtotal=100;
	        wsfe.Lineas_Total=121;
	        wsfe.lineasCargar_I(1);
	        
	        wsfe.Lineas_Codigo="2";
	        wsfe.Lineas_Desc="Producto 2";
	        wsfe.Lineas_Cant=10;
	        wsfe.Lineas_PU=100;
	        wsfe.Lineas_Alic_IVA="10.5";
	        wsfe.Lineas_Subtotal=100;
	        wsfe.Lineas_Total=110.5;
	        wsfe.lineasCargar_I(2);
	        
	        wsfe.Lineas_Codigo="3";
	        wsfe.Lineas_Desc="Producto 3";
	        wsfe.Lineas_Cant=10;
	        wsfe.Lineas_PU=100;
	        wsfe.Lineas_Alic_IVA="21";
	        wsfe.Lineas_Subtotal=100;
	        wsfe.Lineas_Total=121;
	        wsfe.lineasCargar_I(3);
	        
	        wsfe.Lineas_Codigo="4";
	        wsfe.Lineas_Desc="Producto 4";
	        wsfe.Lineas_Cant=10;
	        wsfe.Lineas_PU=100;
	        wsfe.Lineas_Alic_IVA="21";
	        wsfe.Lineas_Subtotal=950.41;
	        wsfe.Lineas_Total=1150;
	        wsfe.lineasCargar_I(4);
	        
	        wsfe.Lineas_Codigo="5";
	        wsfe.Lineas_Desc="Producto 5";
	        wsfe.Lineas_Cant=10;
	        wsfe.Lineas_PU=100;
	        wsfe.Lineas_Alic_IVA="27";
	        wsfe.Lineas_Subtotal=118.11;
	        wsfe.Lineas_Total=150;
	        wsfe.lineasCargar_I(5);
	        
	        wsfe.Lineas_Codigo="6";
	        wsfe.Lineas_Desc="Producto 6";
	        wsfe.Lineas_Cant=10;
	        wsfe.Lineas_PU=100;
	        wsfe.Lineas_Alic_IVA="2.5";
	        wsfe.Lineas_Subtotal=146.34;
	        wsfe.Lineas_Total=150;
	        wsfe.lineasCargar_I(6);
	        
	        //Comp. Asoc.
	     /* wsfe.compAsoc_tipo="1";
			wsfe.compAsoc_ptovta="2";
			wsfe.compAsoc_nro="60";
			wsfe.compAsoc_cuit="27077704257";
			wsfe.compAsoc_fecha="20210722";
			wsfe.compAsocCargar(1); */
	        
	        //Agrego impuestos
	        wsfe.Tributo_codigo="1";
	        wsfe.Tributo_Desc="Impuestos Nacionales";
	        wsfe.Tributo_baseImp=wsfe.totlizar_neto(); //la Base imponible es el total de los importes netos de la factura
	        wsfe.Tributo_alicuota=5.2;
	        wsfe.Tributo_Importe=wsfe.fd((wsfe.totlizar_neto())*0.052,2);
	        wsfe.tributosCargar(1);
	        
	        wsfe.Tributo_codigo="2";
	        wsfe.Tributo_Desc="Impuestos provinciales";
	        wsfe.Tributo_baseImp=wsfe.totlizar_neto(); //la Base imponible es el total de los importes netos de la factura
	        wsfe.Tributo_alicuota=4;
	        wsfe.Tributo_Importe=wsfe.fd((wsfe.totlizar_neto())*0.04,2);
	        wsfe.tributosCargar(2);
	        
	        wsfe.Tributo_codigo="3";
	        wsfe.Tributo_Desc="Impuestos municipales";
	        wsfe.Tributo_baseImp=wsfe.totlizar_neto(); //la Base imponible es el total de los importes netos de la factura
	        wsfe.Tributo_alicuota=1.5;
	        wsfe.Tributo_Importe=wsfe.fd((wsfe.totlizar_neto())*0.015,2);
	        wsfe.tributosCargar(3);
	        
	        wsfe.Tributo_codigo="4";
	        wsfe.Tributo_Desc="Impuestos Internos";
	        wsfe.Tributo_baseImp=wsfe.totlizar_neto(); //la Base imponible es el total de los importes netos de la factura
	        wsfe.Tributo_alicuota=1.5;
	        wsfe.Tributo_Importe=wsfe.fd((wsfe.totlizar_neto())*0.015,2);
	        wsfe.tributosCargar(4);
	        //
	        }
	
	public static void lineas_c() {
    	
        
	      //Agrego Lineas
		    wsfe.Lineas_Codigo="1";
	        wsfe.Lineas_Desc="Producto 1";
	        wsfe.Lineas_Cant=1;
	        wsfe.Lineas_PU=10;
	        wsfe.Lineas_Alic_IVA="0";
	        wsfe.Lineas_Subtotal=100;
	        wsfe.Lineas_Total=100;
	        wsfe.lineasCargar_I(1);
	        
	        wsfe.Lineas_Codigo="2";
	        wsfe.Lineas_Desc="Producto 2";
	        wsfe.Lineas_Cant=1;
	        wsfe.Lineas_PU=10;
	        wsfe.Lineas_Alic_IVA="0";
	        wsfe.Lineas_Subtotal=300;
	        wsfe.Lineas_Total=300;
	        wsfe.lineasCargar_I(2);
	        
	       
	        //
	        }
}
