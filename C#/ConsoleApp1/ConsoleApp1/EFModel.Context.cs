﻿//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace ConsoleApp1
{
    using System;
    using System.Data.Entity;
    using System.Data.Entity.Infrastructure;
    using System.Data.Entity.Core.Objects;
    using System.Linq;
    
    public partial class EMPDBEntities2 : DbContext
    {
        public EMPDBEntities2()
            : base("name=EMPDBEntities2")
        {
        }
    
        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            throw new UnintentionalCodeFirstException();
        }
    
        public virtual DbSet<courses> courses { get; set; }
        public virtual DbSet<dept> dept { get; set; }
        public virtual DbSet<employee> employee { get; set; }
        public virtual DbSet<instructor> instructor { get; set; }
        public virtual DbSet<databaselog> databaselog { get; set; }
    
        public virtual int delete_emp(Nullable<int> emp_id)
        {
            var emp_idParameter = emp_id.HasValue ?
                new ObjectParameter("emp_id", emp_id) :
                new ObjectParameter("emp_id", typeof(int));
    
            return ((IObjectContextAdapter)this).ObjectContext.ExecuteFunction("delete_emp", emp_idParameter);
        }
    }
}