package tei;

import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;

public class JavaConnect {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		
		try {
			MongoClient mongoClient = new MongoClient("localhost",27017);
			mongoClient.setWriteConcern(WriteConcern.JOURNAL_SAFE);
			DB db = mongoClient.getDB("fooat");
			DBCollection collection = db.getCollection("tet");
			System.out.println("Number of Documents: " + new Long(collection.count()).toString());
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			System.out.println(e);
		}
		

	}

}
