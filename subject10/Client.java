public class Client
{ public static void main(String[] args){
Koujyou koujyou1 = new TvKoujyou();
Koujyou koujyou2 = new RadioKoujyou();

Seihin[] array = new Seihin[3];
array[0] = koujyou1.create();
array[1] = koujyou2.create();
array[2] = koujyou1.create();
for (int i = 0; i < array.length; ++i) { array[i].print();
		}
	}
}

//製作者についてのクラス
abstract class Koujyou {
public final Seihin create() {
Seihin seihin = factoryMethod(); touroku(seihin);
return seihin;
}
public abstract Seihin factoryMethod();
public abstract void touroku(Seihin s);
}

//具体的な製作者1
class TvKoujyou extends Koujyou{
public Seihin factoryMethod(){	//製品を実体化して返却
return new Television();
}
public void touroku(Seihin s) {
Television t = (Television) s;
t.numberring(); t.setDate(Date.today());
	}
}

//具体的な製作者2
class RadioKoujyou extends Koujyou {
public Seihin factoryMethod(){	//製品を実体化して返却
return new Radio();
}
public void touroku(Seihin s) {
Radio r = (Radio) s; r.numberring();
	}
}

abstract class Seihin{
public abstract void print();
}

//具体的な製品1
class Television extends Seihin {
private int tvSerialNumber;
private String date;

public void numberring(){
tvSerialNumber = Counter.getTvNumber(); //テレビの製造番号持って来い
}

public void setDate(String date){
this.date = date;	//日付を持ってくる準備
}

public void print(){
System.out.println("このテレビに関する情報:");
System.out.println(" 製造番号:" + tvSerialNumber);
System.out.println(" 製造年月日:" + date);
	}
}

//具体的な製品2
class Radio extends Seihin{
private int radioSerialNumber;

public void numberring(){
radioSerialNumber = Counter.getRadioNumber(); //ラジオの製造番号持って来い
}

public void print(){
System.out.println("このラジオに関する情報:");
System.out.println(" 製造番号:" + radioSerialNumber);
	}
}

//日付を返す
class Date {
public static String today(){
return "2004/01/20";
	}
}

//製造番号を返す
class Counter{
private static int tvNum = 100; //テレビの製造番号
private static int radioNum = 76; //ラジオの製造番号
public static int getTvNumber(){
return tvNum++;
}

public static int getRadioNumber(){
return radioNum++;
	}
}
