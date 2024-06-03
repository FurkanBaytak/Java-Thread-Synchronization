// Class'tan üretilen tüm objeler Thread olarak üretiliyor. (1.Yöntem, bu yöntem birden fazla extends ihtiyacı gerektirdiği zaman bu şansı Threads ile kullandığınız için OOP mantığını engeller.)
class producers extends Thread {
    data d;

    public producers(data d) {
        this.d = d;
    }

    public void run(){
        for(int i = 0; i < 10; i++){

            // Java'da "Mutex" işlemi bu şekilde gerçekleştirebilir. Bunun anlamı bu işlem bitene kadar başka bir işlem gerçekleşmesine izin vermeyecek demektir.
            synchronized(d){
                
                // Java'da "Progress" işlemi bu şekilde gerçekleştirilebilir. Producer üretmeden Consumer tüketememesi için bu işlem sıralamasına uymak için gerçekleştirilir.
                if(d.semaphore == false){
                    d.value++;
                    System.out.println("producer: " + d.value);
                }
            }

        }
        d.semaphore = true;
    }
}