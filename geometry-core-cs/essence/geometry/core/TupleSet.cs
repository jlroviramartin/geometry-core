namespace essence.geometry.core
{
    public interface TupleSet
    {
        void SetByte(int index, byte value);

        void SetShort(int index, short value);

        void SetInteger(int index, int value);

        void SetLong(int index, long value);

        void SetFloat(int index, float value);

        void SetDouble(int index, double value);

        void Set<T>(int index, T value);
    }
}
