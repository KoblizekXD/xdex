package lol.koblizek.xdex.io.items;

public record ClassDefItem(
        int classIdx,
        int accessFlags,
        int superclassIdx,
        int interfacesOff,
        int sourceFileIdx,
        int annotationsOff,
        int classDataOff,
        int staticValuesOff
) {
}
