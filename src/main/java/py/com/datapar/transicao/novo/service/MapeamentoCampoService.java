package py.com.datapar.transicao.novo.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("mapeamentoCampoService")
public class MapeamentoCampoService {

	private final String sqlCamposOracle = "select distinct t.table_name, t.comments comente_t, c.column_name, co.data_type, co.data_length, co.data_precision, c.comments comente_c"
			+ " from user_col_comments c ,user_tab_comments t, USER_TAB_COLUMNS co"
			+ " where co.column_name = c.column_name and  c.table_name = t.table_name and co.table_name= c.table_name "
			+ " order by t.table_name, c.column_name";

	@Autowired
	@Qualifier("oldEntityManagerFactory")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<CampoInfoJson> listaInfoCampos() {

		
		List<CampoInfoJson> info = new ArrayList<>();
		
		List<Object[]> queryCampos = em.createNativeQuery(sqlCamposOracle).getResultList();
		
		for (Object[] registro : queryCampos) {
			info.add( new CampoInfoJson(
					registro[0] != null ? registro[0].toString() : null,
					registro[1] != null ? registro[1].toString() : null,
					registro[2] != null ? registro[2].toString() : null, 
					registro[3] != null ? registro[3].toString() : null, 
					registro[4] != null ? registro[4].toString() : null,
					registro[5] != null ? registro[5].toString() : null,
					registro[6] != null ? registro[3].toString() : null ) 
					);
		}

		return info;
		
		
	}

}
