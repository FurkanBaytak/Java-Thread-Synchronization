// d objesini her yerde aynı şekilde tanımladık, yani memory'deki "d" değişkeni herkes tarafından paylaşılıyor,
// Thread'lerin temel mantığı göz önünde bulundurularak bu değişkeni herkes tarafından erişilebilir yaptık.
// Yani bu "d" objesinin değeri herhangi bir yerde değiştirilirse tüm thread'lerde aynı bilgi olacağından,
// consumer bu değişkeni değiştirirse producer da değiştirilmiş değişkeni görmüş olacak.

// Bu kod çalıştırıldığı zaman, teorik olarak "d" değişkenimiz 10 kere artırılıp 10 kere azaltılıyor.
// Ancak bu işlemler Thread kullanılarak yapıldığı için "Process Synchronization" hatası olarak "Race Condition" karşımıza çıkıyor.
// "Race Condition" atomic bir işlem değildir, yani sadece bir işlem gerçekleşmez, d.value++ yazıldığı zaman gerçekleşen işlem;
//      register1 = counter;
//      register1 = register1 + 1;
//      counter = register1;
// Bu işlemlerin sırası şu anda belirtilmediği için, işlemlerin sırası birbiri ile karışıp beklenmeyen durumlara yol açıyor.
// Yani yukarıdaki 3 satırlı işlem gerçekleşirken araya d.value-- işlemi için yapılacak olan 3 işlem karışabiliyor.
// Örneğin 100 olan bir sayının 10 kere artırılıp 10 kere azaltılmasına rağmen son durumda değeri 99 ya da 101 gibi değerler olabiliyor.

// Solution to Critical-Section Problem
// - Mutual Exclusion (Olayların biri tamamen bitmeden diğerinin başlayamaması.)
//      Bu kod içerisinde "synchronized()" kullanarak bu işlemi gerçekleştirdik.
// - Progress (Olayların sırası, producer üretmeden, consumer'in tüketememesini gerçekleştirmek için.)
//      Bu kod içerisinde "semaphore" kullanarak sırayla çalışabilmelerini sağladık.
// - Bounded Waiting (Bu kodda kullanılmadı.)

public class osThread {
    public static void main(String[] args) {
        data d = new data();
        d.value = 100;

        d.semaphore = false;

        producers p = new producers(d);
        consumer c = new consumer(d);

        // consumer başta Thread olarak tanımlanmadığı için, buna Thread gibi davranabilmek için bu işlemi yapıyoruz.
        Thread t = new Thread(c);

        p.start();
        t.start();
    }
}