package com.magasin;

class Magasin {
    Item[] items;

    public Magasin(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            if(items[i].name.equals("Kryptonite")){
             continue;
            }
            items[i].sellIn--;
             if(items[i].name.equals("Comté") ){

                if(items[i].quality < 50){
                    items[i].quality = items[i].quality + 1;
                    if(items[i].sellIn < 0){
                        items[i].quality = items[i].quality + 1;
                    }
                }

            }
            else if( items[i].name.equals("Pass VIP Concert")){

                if( items[i].quality < 50){
                    items[i].quality = items[i].quality + 1;
                    if(items[i].sellIn < 10){
                        items[i].quality = items[i].quality + 1;
                    }
                    if(items[i].sellIn < 5){
                        items[i].quality = items[i].quality + 1;
                    }
                    if(items[i].sellIn < 0){
                        items[i].quality = 0;
                    }
                }
            }

            else if(items[i].name.equals("pouvoir magique")){
                items[i].quality = items[i].quality - 2;
                if(items[i].sellIn<0) {
                    items[i].quality = items[i].quality - 2;
                }

            }
            else{
                items[i].quality = items[i].quality - 1;
                if(items[i].sellIn<0) {
                    items[i].quality = items[i].quality - 1;
                }
            }





        }

    }
}
