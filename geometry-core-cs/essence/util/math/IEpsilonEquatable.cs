namespace essence.util.math
{
    public interface IEpsilonEquatable<in T>
    {
        bool EpsilonEquals(T other, double epsilon);
    }
}