package fateczl.aps.aula_3mobile;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView tvGasolina;
    private EditText etGasolina;
    private TextView tvEtanol;
    private EditText etEtanol;

    private TextView tvResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvGasolina = findViewById(R.id.tvGasolina);
        tvEtanol = findViewById(R.id.tvEtanol);
        etGasolina = findViewById(R.id.etGasolina);
        etEtanol = findViewById(R.id.etEtanol);
        tvResultado = findViewById(R.id.tvResultado);

        Button btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener( operacao -> qualCompensaMaisGasolinaOuEtanol());

    }

    private void qualCompensaMaisGasolinaOuEtanol() {
        float precoGasolina = Float.parseFloat(etGasolina.getText().toString());
        float precoEtanol = Float.parseFloat(etEtanol.getText().toString());

        // Calcula o preço equivalente do etanol em relação à gasolina
        float precoEquivalenteGasolina = precoGasolina * 0.7f;

        if (precoEquivalenteGasolina >= precoEtanol) {
            tvResultado.setText("");
            etGasolina.setText("");
            etEtanol.setText("");

            tvResultado.setText("Abasteça com Etanol!");
        } else {
            tvResultado.setText("");
            etGasolina.setText("");
            etEtanol.setText("");

            tvResultado.setText("Abasteça com Gasolina!");
        }

    }


}