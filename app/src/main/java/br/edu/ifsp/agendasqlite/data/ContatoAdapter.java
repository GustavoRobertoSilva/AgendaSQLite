package br.edu.ifsp.agendasqlite.data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.edu.ifsp.agendasqlite.R;
import br.edu.ifsp.agendasqlite.model.Contato;

public class ContatoAdapter
        extends RecyclerView.Adapter<ContatoAdapter.ContatoViewHolder>  {

    static List<Contato> contatos;

    private static ItemClickListener clickListener;


    public void adicionaContatoAdapter(Contato c)
    {
        contatos.add(0,c);
        notifyItemInserted(0);

    }

    public void atualizaContatoAdapter(Contato c)
    {

        contatos.set(contatos.indexOf(c),c);
        notifyItemChanged(contatos.indexOf(c));

    }

    public void apagaContatoAdapter(Contato c)
    {
        int pos = contatos.indexOf(c);
        contatos.remove(pos);
        notifyItemRemoved(pos);

    }




    public void setClickListener(ItemClickListener itemClickListener)
    {
        clickListener = itemClickListener;

    }

    public ContatoAdapter(List<Contato> contatos)
    {
        this.contatos = contatos;
    }

    @NonNull
    @Override
    public ContatoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                   .inflate(R.layout.contato_celula,parent,false);

        return new ContatoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContatoViewHolder holder, int position) {
            holder.nome.setText(contatos.get(position).getNome());
    }

    @Override
    public int getItemCount() {
        return contatos.size();
    }






    public class ContatoViewHolder
            extends RecyclerView.ViewHolder
            implements View.OnClickListener
    {
        final TextView nome;

        public ContatoViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = (TextView) itemView.findViewById(R.id.nome);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
              if (clickListener!=null)
                  clickListener.onItemClick(getAdapterPosition());
        }
    }


    public  interface ItemClickListener
    {
        void onItemClick(int position);
    }


}