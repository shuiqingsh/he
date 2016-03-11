package tei;

//这是第四次上传数据

import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class JavaFind {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		
		try {
			MongoClient mongoClient = new MongoClient("localhost",27017);
			DB db = mongoClient.getDB("fooat");
			DBCollection collection = db.getCollection("tet");
			JavaFind.getOne(collection);
			//JavaFind.getManyWhile(collection);
			JavaFind.getManyFor(collection);
			JavaFind.getManyToArray(collection);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			System.out.println(e);
		}
		

	}
	public static void getOne(DBCollection collection){
		
		DBObject doc = collection.findOne();
		System.out.println("single Document : ");
		System.out.println(doc.toString());
	}
	public static void getManyWhile(DBCollection collection){
		DBCursor cursor = collection.find();
		Long count = 0L;
		while(cursor.hasNext()){
			DBObject doc = cursor.next();
			count += (Long)Math.round((Double)doc.get("mie"));
			
		}
		System.out.println("\nTotal characters using While loop: ");
		System.out.println(count);
	}
	public static void getManyFor(DBCollection collection){
		System.out.println("\nFor loop iteration: ");
		BasicDBObject query = new BasicDBObject("ge",6);
		DBCursor cursor = collection.find(query);
		
		while(cursor.hasNext()){
			DBObject doc = cursor.next();
			System.out.println(doc.toString());
			
		}
		/*for(Integer i = 0;i<1; i++){
			doc = cursor.next();
			System.out.println(doc.get("ge"));
			System.out.println(doc.get("ei"));
			
		}*/
	}
	public static void getManyToArray(DBCollection collection){
		System.out.println("\nConverted to array iteration: ");
		DBCursor cursor = collection.find();
		List<DBObject> docs = cursor.toArray(2);
		for(final DBObject doc : docs){
			System.out.println(doc.get("mie"));
		}
	}
}
