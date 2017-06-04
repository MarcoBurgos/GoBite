package com.marcoburgos.gobite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;

/**
 * Created by marcoburgos on 30/04/17.
 */

public class Subway_Sandwiches extends AppCompatActivity implements SandwichesAdaptador.ItemClickCallback {
    private RecyclerView reciclador;
    private RecyclerView.LayoutManager lmanager;
    private SandwichesAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.mipmap.arrow_left);
        actionBar.setDisplayShowHomeEnabled(true);
        setTitle("Sándwiches");
        setContentView(R.layout.activity_main_sandwiches);
        ArrayList<Sandwiches_MC> datos = new ArrayList<Sandwiches_MC>();
        datos.add(new Sandwiches_MC(R.drawable.carneyqueso, "Carne y Queso", "Deliciosas tiras de carne de res, sazonada con cebolla, pimientos verdes y queso derretido que se deshace en tu boca. Se sirve calientito con los vegetales y aderezos de tu elección sobre pan recién horneado ¡Con guacamole sabe aún más rico!", "$79.00"));
        datos.add(new Sandwiches_MC(R.drawable.chickenbacon, "Chicken and Bacon Ranch", "Exquisita pechuga de pollo acompañada con uno de los ingredientes favoritos: ¡tocino crujiente! Con queso derretido, salsa ranch y una gran variedad de vegetales frescos que hacen que este SUB tenga un sabor único. ¡No esperes más para probarlo!", "$79.00"));
        datos.add(new Sandwiches_MC(R.drawable.costillabbq, "Costillas BBQ con queso", "Pan recién hecho con la ya famosa carne de costillita de cerdo aderezada a la BBQ, con queso y tu selección favorita de vegetales. ¡Una deliciosa receta que te encantará!", "$79.00"));
        datos.add(new Sandwiches_MC(R.drawable.roastbeef, "Roast Beef", "Para cuando tienes antojo y no sabes qué pedir, este SUB es una gran opción. Hecho a base de roast beef bajo en grasa que puedes acompañar con los vegetales y aderezos que quieras. ¡Un SUB que seguramente volverás a pedir!", "$79.00"));
        datos.add(new Sandwiches_MC(R.drawable.albongida, "Albóndigas", "Elaborado a base de una generosa ración de albóndigas sazonadas al estilo italiano, bañadas en nuestra exclusiva salsa marinara (deliciosa receta de la casa). Se sirve calientito sobre exquisito pan recién horneado, acompañado de los frescos y crujientes vegetales de tu elección y aderezo. ¡Simplemente DELICIOSO!", "$79.00"));
        datos.add(new Sandwiches_MC(R.drawable.teriyaki, "Pollo Estilo Teriyaki", "Un clásico de Asia por su exquisita salsa agridulce. Hecho a base de pechuga de pollo bañada en deliciosa salsa Teriyaki. Se sirve calientito y cubierto de los vegetales y aderezos que tú prefieras. ¡Definitivamente un sabor que será irresistible a tu paladar!", "$70.00"));
        datos.add(new Sandwiches_MC(R.drawable.subwayclub, "Subway Club", "Uno de los más pedidos, por el exquisito sabor de su famosa pechuga de pavo sin grasa, rebanadas de roast beef y jamón, los vegetales que más te gusten, especias y aderezos. ¡Una de las recetas favoritas de la casa!", "$70.00"));
        datos.add(new Sandwiches_MC(R.drawable.polloparmesano, "Pollo Parmensano", "Uno de los subs preferidos del viejo mundo. Con pollo empanizado en queso parmesano, salsa marinara, queso, jitomates y los vegetales que prefieras. ¡Una vez que lo pruebas, no podrás dejar de pedirlo!", "$70.00"));
        datos.add(new Sandwiches_MC(R.drawable.italianobmt, "Italiano BMT", "El rico sabor de Italia. Salami rebanado, pepperoni y jamón, acompañado de vegetales y condimentos. ¡La verdad es que con sólo verlo, se antoja!", "$70.00"));
        datos.add(new Sandwiches_MC(R.drawable.atun, "Atún", "Fresco y con mayonesa, acompañado de los vegetales, especias y el aderezo que prefieras, servido en pan recién horneado. ¡El más rico de todo el mundo!", "$50.00"));
        datos.add(new Sandwiches_MC(R.drawable.jamonpavo, "Jamón de Pavo", "Deliciosas rebanadas de jamón de pavo estilo gourmet, servido con tu selección de vegetales frescos y condimentos sobre el exquisito pan que tú elijas. ¡Delicioso y saludable!", "$50.00"));
        datos.add(new Sandwiches_MC(R.drawable.pizzasbu, "Pizza Sub", "¡Lo más representativo de Italia! Un SUB hecho con pepperoni, queso, salsa marinara, lechuga, jitomates, pepinillos, pimientos verdes, cebolla y el aderezo que gustes… ¡ri-quí-si-mo!", "$50.00"));
       // datos.add(new Sandwiches_MC(R.drawable.tarjetaveggie, "Sub de Pollo", "¿Te atreves a probar un pollo diferente? Deliciosa pechuga de pollo asada, acompañada de nuestros exquisitos vegetales y aderezos. ¡Una receta diferente y de mucha tradición!", "$50.00"));
        datos.add(new Sandwiches_MC(R.drawable.spicyitalian, "Spicy Italian", "Una mezcla de pepperoni y salami, cubierta con queso. Pruébalo con los vegetales y condimentos que prefieras, sobre pan recién horneado.", "$50.00"));
        datos.add(new Sandwiches_MC(R.drawable.jamon, "Jamón", "Exquisitas rebanadas del más selecto jamón, sobre una cama de vegetales frescos y aderezos. ¡Una clásica receta que a todos encanta!", "$40.00"));
        datos.add(new Sandwiches_MC(R.drawable.deleitevegetariano, "Deleite Vegetariano", "¡Wow! Una combinación de lechuga, jitomates, pimientos verdes, cebolla y aderezos de tu elección sobre pan recién horneado. Es como si una ensalada la hicieras SUB(R) ¡mmm, fresco y delicioso!", "$40.00"));



        reciclador = (RecyclerView) findViewById(R.id.recicladorDetalleSanwiches);
        lmanager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        reciclador.setLayoutManager(lmanager);

        adaptador = new SandwichesAdaptador(datos);
        reciclador.setAdapter(adaptador);
        adaptador.setItemClickCallback(this);



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, MainActivity_Menu_Subway.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
}
    @Override
    public void onItemClick(int p) {
        Intent i = new Intent(this, ConfigurarPizza.class);
        startActivity(i);
    }
}