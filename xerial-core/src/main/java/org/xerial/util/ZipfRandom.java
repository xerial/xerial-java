/*--------------------------------------------------------------------------
 *  Copyright 2009 Taro L. Saito
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *--------------------------------------------------------------------------*/
//--------------------------------------
// Xerial Raquel Project
//
// ZipfRandom.java
// Since: Mar 6, 2009 5:20:14 PM
//
// $URL: https://www.xerial.org/svn/project/XerialJ/trunk/xerial-raquel/src/main/java/org/xerial/raquel/ZipfRandom.java $
// $Author: leo $
//--------------------------------------
package org.xerial.util;

import java.util.Random;

/**
 * Generate a random number following a Zipf distribution.
 * 
 * @author leo
 * 
 */
public class ZipfRandom
{
    private final double N;
    private final double alpha;

    private final Random uniformDistribution;

    /**
     * normalization constant
     */
    private double c;

    /**
     * Create a new Zipf random number generator. This constructor sets the seed
     * of of the random number generator range
     * 
     * @param alpha
     *            degree of data skew. If this alpha value is 2 or 3, the
     * @param N
     *            the bound on the random number to be returned. This value must
     *            be positive
     */
    public ZipfRandom(double alpha, int N)
    {
        this(System.currentTimeMillis(), alpha, N);
    }

    public ZipfRandom(long seed, double alpha, int N)
    {
        this.uniformDistribution = new Random(seed);

        if (N <= 0)
            throw new IllegalArgumentException("N must be positive");

        this.N = N;
        this.alpha = alpha;

        // Compute normalization constant on first call only
        for (int i = 1; i <= N; i++)
            c = c + (1.0 / Math.pow((double) i, alpha));
        c = 1.0 / c;
    }

    public int nextInt()
    {
        double zipfValue = 0; // Computed exponential value to be returned

        // Pull a uniform random number (0 <= z < 1). 
        double uniformRandom = uniformDistribution.nextDouble();

        // Map z to the value
        double sumOfProbability = 0;
        for (int i = 1; i <= N; i++)
        {
            sumOfProbability += c / Math.pow((double) i, alpha);
            if (sumOfProbability >= uniformRandom)
            {
                zipfValue = i;
                break;
            }
        }

        // Assert that zipf_value is between 1 and N
        assert ((zipfValue >= 1) && (zipfValue <= N));

        return (int) zipfValue;
    }
}
