import java.util.Scanner;

public class InterfazTPV {
    Scanner src = new Scanner(System.in);
    int recuentoCaja=0;

    public String crearFactura (Mesas mesas) {
        int opcion;
        String mensaje = "Error not found TPV";
        do {
            System.out.println("------¡Bien venido al menú!------\n");
            System.out.println("¿Qué opción desea realizar?\n" +
                    "1-Listar todas las mesas\n" +
                    "2-Listar mesas abiertas\n" +
                    "3-Listar mesas cerradas\n" +
                    "4-Gestionar Mesa abierta\n" +
                    "5-Recuento Caja\n" +
                    "6-Apagar TPV\n"
            );
            opcion = src.nextInt();
            switch (opcion) {
                case 1:
                    mesas.listarMesas(mesas);
                    break;
                case 2:
                    mesas.mostrarMesasAbiertas(mesas);
                    break;
                case 3:
                    mesas.mostrarMesasCerradas(mesas);
                    break;
                case 4:
                    menuGestionarMesa(mesas);
                    break;
                case 5:
                    System.out.println("El recuento de la caja hasta ahora es de: "+recuentoCaja);
                    break;
                case 6:
                    System.out.println(mensaje = "Adiós");
                    break;
            }

        } while (opcion!=6);
        return mensaje;
    }

    public void menuGestionarMesa(Mesas mesas) {
        int opcion;

        String codMesa, nomProducto, annadirOtroProducto;
        double precioProducto;

        System.out.println("1-Realizar pedido");

        System.out.println("2-Pagar cuenta");

        opcion=src.nextInt();

        if(opcion==1){
            // realizarPedio();
            mesas.mostrarMesasAbiertas(mesas);
            System.out.println("Introduce el código de una mesa disponible: ");
            codMesa=src.next();
            Mesa mesa = mesas.elegirMesaAFacturar(codMesa);

            do {
                System.out.println("Indique un producto: ");
                nomProducto = src.next();
                System.out.println("Indique el precio del producto: ");
                precioProducto = src.nextDouble();
                System.out.println("¿Desea añadir otro producto?");
                annadirOtroProducto=src.next();
                mesa.getListaProductos().annadirProducto(nomProducto,precioProducto);


            }while ( annadirOtroProducto.equalsIgnoreCase("SI"));
            System.out.println(codMesa);
            mesa.getListaProductos().listarProductos();

        }
        else {
            mesas.mostrarMesasAbiertas(mesas);
            System.out.println("Introduce el código de una mesa disponible: ");
            codMesa=src.next();
            Mesa mesa = mesas.elegirMesaAFacturar(codMesa);
            int totalMesa= mesa.getListaProductos().crearFactura();
            this.recuentoCaja+=totalMesa;
            System.out.println("La factura para esta mesa es: "+totalMesa);
            mesa.setMesaAbierta(false);
        }
    }
}




