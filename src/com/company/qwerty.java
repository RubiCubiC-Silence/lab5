/**
 * @author RubiCubiC
 */
package com.company;

public class qwerty {
    private static int n,s; //n - количество блоков // s - длина блоков
    private static float[] masb;
    /**
     * Выполнение sqrt-декомпозиции исходного массива на блоки сумм
     * @param mas исходный массив для выполнения декомпозиции
     * @return возвращает массив блоков
     */
    public static void dec (float[] mas) {
        s = (int)Math.floor(Math.sqrt(mas.length)); //s - длина блоков
        n = s;
        if (Math.sqrt(mas.length) - n > 0.00000001)
            n++;

        float[] sqrtmas = new float[n];
        int j = 0;
        for (int i = 0; i<mas.length; i++)
        {
            sqrtmas[j] = sqrtmas[j] + mas[i];
            if ((i+1) % s == 0)
            {
                j++;
            }
        }

        masb = sqrtmas;
    }

    /**
     * Нахождение суммы на интервале
     * @param l левая граница интервала
     * @param r правая граница интервала
     * @param mas1 исходный массив
     * @return возвращает сумму на интервале
     */

    public static float sum (int l, int r, float[] mas1)
    {
        float sum = 0;
        for (int i = l; i<=r; )
        {
            if (i % s == 0 && i+s - 1 <= r)
            {
                sum = sum + masb[i / s];
                i = i + s;
            }
            else
            {
                sum = sum + mas1[i];
                i++;
            }

        }
        return sum;
    }

    /**
     * изменение значения исходного массива и массива блоков
     * @param x новое значение
     * @param i номер изменяемого элемента
     * @param mas1 исходный массив
     */
    public static void change (float x, int i, float[] mas1)
    {
        masb[i/s] += x - mas1[i];
        mas1[i] = x;
    }

    /**
     * изменение значений на интервале исходного массива и массива блоков
     * @param l левая граница
     * @param r правая граница
     * @param x новое значение
     * @param mas1 исходный массив
     */
    public static void changeInterval (int l, int r, float x, float[] mas1)
    {
        for (int i = l; i<=r; )
        {
            change(x, i, mas1);
            i++;
        }
    }
}
