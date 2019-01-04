using System.Collections.Generic;

namespace EF_Learning
{
    public class Grade
    {
        public int GradeID { get; set; }
        public string GradeName { get; set; }
        public string SectionName { get; set; }

        public ICollection<Student> Students { get; set; }
    }
}