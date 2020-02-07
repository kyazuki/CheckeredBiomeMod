# CheckeredBiomeMod
Buggy Biomes!

## 対応バージョン
Minecraft: 1.15.2<br>
Minecraft Forge: 31.0.0以上<br>
http://files.minecraftforge.net/maven/net/minecraftforge/forge/index_1.15.2.html

## 適用方法
ワールド新規作成画面から、その他のワールド設定->ワールドタイプを"チェッカー"に指定してください。

## 概説
バイオームがチャンク毎に変わります。<br>
同種のバイオームばかり出現するのを回避するために、<br>
一部バイオームは出現しないようになっています。(主に〇〇_HILLS)

## configファイル
Modを導入した状態で一回でも起動すると、configフォルダ内にcheckeredbiomemod-client.tomlが生成されます。<br>
値の変更は次回起動以降の**チャンク生成時**に適用されます。
- enable_nether_biome
  - オーバーワールドにおいて、ネザーのバイオームを生成するかどうか。<br>
    trueかfalseで指定でき、デフォルトはfalseです。
- enable_the_end_biome
  - オーバーワールドにおいて、エンドのバイオームを生成するかどうか。<br>
    trueかfalseで指定でき、デフォルトはfalseです。
- activate_in_nether
  - ネザーでのワールド生成にこのModを適用させるかどうか。<br>
    このMod適用時のオーバーワールドと同じように生成されます。<br>
    trueかfalseで指定でき、デフォルトはfalseです。
- activate_in_the_end
  - ネザーでのワールド生成にこのModを適用させるかどうか。<br>
    このMod適用時のオーバーワールドと同じように生成されます。<br>
    trueかfalseで指定でき、デフォルトはfalseです。

## 注意点
- シングルプレイのみ対応です。
