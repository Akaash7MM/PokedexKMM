import SwiftUI
import shared
import KMPNativeCoroutinesAsync

struct ContentView: View {
    let viewmodel = PokedexVM().getPokedexViewModel()
	var body: some View {
        let result = await asyncResult(for: viewmodel.pokemonList)
        
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
