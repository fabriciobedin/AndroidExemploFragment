package br.com.encode.exemplofragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by fabricio on 23/08/2016.
 */
public class DetailFragment extends Fragment {

    public TextView txtNome;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, null);

        txtNome = (TextView) view.findViewById(R.id.txtNomeItem);

        return view ;
    }

    public void setNome(String nome){
        txtNome.setText(nome);
    }
}

