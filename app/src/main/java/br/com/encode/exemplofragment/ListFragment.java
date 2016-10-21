package br.com.encode.exemplofragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fabricio on 23/08/2016.
 */
public class ListFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, null);

        ListView listView = (ListView) view.findViewById(R.id.listItens);

        final List<String> opcoes = new ArrayList<String>();
        opcoes.add("Massa");
        opcoes.add("Ovo");
        opcoes.add("Arroz");
        opcoes.add("Feijão");
        opcoes.add("Chocolate");

        ArrayAdapter adapter = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1, opcoes);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int indice, long l) {
                selecionouItem(opcoes.get(indice));
            }
        });

        return view;
    }

    public void selecionouItem(String item){
        //verificar se está em landscape ou portrait
        FragmentManager fMgr = getFragmentManager();
        DetailFragment fragment = (DetailFragment) fMgr.findFragmentById(R.id.detailFragment);

        if(fragment != null && fragment.isInLayout()){
            //landscape
            fragment.setNome(item);
        }else{
            //portrait
            Intent intent = new Intent(getActivity(), DetailActivity.class);
            startActivity(intent);
        }
    }
}
