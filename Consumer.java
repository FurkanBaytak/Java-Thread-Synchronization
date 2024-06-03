// Runnable interface'i kullanılarak run() fonksiyonunu override edilecek. (2.Yöntem, bu yöntem tercih edilmesi gereken yöntem. Implements üzerine extends kullanılabileceği için multiple inheritence yapılabilir.)
class consumer implements Runnable {
    data d;

    public consumer(data d){
        this.d = d;
    }

    // Override edilen fonksiyon, bu yöntemde çalışmak için zorunlu olarak Thread'lerin güncellenmesi için gereken fonksiyon.
    public void run(){
        for(int i = 0; i < 10; i++){

            // Java'da "Mutex" işlemi bu şekilde gerçekleştirebilir. Bunun anlamı bu işlem bitene kadar başka bir işlem gerçekleşmesine izin vermeyecek demektir.
            synchronized(d){
                if(d.semaphore == true){
                    d.value--;
                    System.out.println("consumer: " + d.value);
                }
            }
            
        }
        d.semaphore = false;
    }
}