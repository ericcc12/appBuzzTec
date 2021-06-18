package com.example.buzztec.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.buzztec.dto.DtoAtividade;

public class DaoAtividade extends SQLiteOpenHelper
{
    public final String TABELA_ATIVIDADE = "TB_ATIVIDADE";

    public DaoAtividade(@Nullable Context context) {
        super(context, "db_buzztec", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db_buzztec)
    {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db_buzztec, int oldVersion, int newVersion) {

    }
    public long CadastrarAtividade(DtoAtividade dtoAtividade)
    {
        ContentValues dados = Colunas(dtoAtividade);

        return getWritableDatabase().insert(TABELA_ATIVIDADE, null, dados);
    }

    private ContentValues Colunas(DtoAtividade dtoAtividade)
    {
        ContentValues dados = new ContentValues();
        dados.put("DataIni", String.valueOf(dtoAtividade.getDataInicio()));
        dados.put("DataTer", String.valueOf(dtoAtividade.getDataTermino()));
        dados.put("Consultor",  dtoAtividade.getNm_consultor());
        dados.put("Cliente",  dtoAtividade.getNm_consultor());
        dados.put("DescAtividade",  dtoAtividade.getDesc_atividade());
        return dados;
    }

}
