object Runner {
    @JvmStatic
    fun main(args: Array<String>){
        val p8 = Pico8()
        val celeste = Celeste(p8)
        p8.load_game(celeste)
        p8.set_btn_state(0)
        celeste.load_room(0 % 8, 0)

        while(celeste.get_player()!!::class.java == Celeste.player_spawn::class.java){
            p8.step()
        }

        println(celeste.getString().replace("\n", "<br>"))

        while (true){
            val input = readln()
            p8.set_btn_state(0)
            for(c in input){
                if(c == 'r'){
                    p8.set_inputs(r=true)
                }
                if(c == 'l'){
                    p8.set_inputs(l=true)
                }
                if(c == 'z'){
                    p8.set_inputs(z=true)
                }
            }
            p8.step()
            println()
            println(celeste.getString())
        }
    }
}