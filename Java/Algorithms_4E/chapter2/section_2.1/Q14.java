/*
 * 设牌的张数为N
 * loop： i=N
 *      如果i为1，排序完成，否则进入以下步骤
 *          观看最上面两张牌，将较大的牌交换到最上面
 *          将最上面的牌放到最下面
 *          重复放置N-1次
 *       无需比较，将最上面的牌放到最底下（N-i）次
 *       i = i - 1
 *      goto loop
 *  这么做会保证每次选取最小的牌，进行N次排序之后，序列就是有序的了
 */

public class Q14 {}